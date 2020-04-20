package com.example.demo.service.movie.personal;

import com.example.demo.exception.ProducerNotFoundException;
import com.example.demo.persistance.model.movie.personal.producer.Producer;
import com.example.demo.persistance.repository.movie.personal.ProducerRepository;
import com.example.demo.rest.model.movie.personal.producer.ProducerRequestModel;
import com.example.demo.rest.model.movie.personal.producer.ProducerResponseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProducerService {
    private final static Logger LOGGER = LoggerFactory.getLogger(ProducerService.class);

    private final ProducerRepository producerRepository;

    public ProducerService(ProducerRepository producerRepository) {
        this.producerRepository = producerRepository;
    }

    //region public Methods

    public ProducerResponseModel create(ProducerRequestModel producerRequestModel){
        LOGGER.info("Request to create producer - {}",producerRequestModel);
        Producer producer = buildProducerFrom(producerRequestModel);
        Producer createProducer = producerRepository.save(producer);
        ProducerResponseModel producerResponseModel = buildProducerResponseModelFrom(createProducer);
        LOGGER.info("Producer successfully created - {}",producerResponseModel);
        return producerResponseModel;
    }

    public List<ProducerResponseModel> selectAllProducers(){
        LOGGER.info("Request to select all producers");
        List<Producer> producers = producerRepository.findAll();
        List<ProducerResponseModel> collect = producers.stream()
                .map(this::buildProducerResponseModelFrom)
                .collect(Collectors.toList());
        LOGGER.info("All producers successfully selected - {}",collect);
        return collect;
    }

    public ProducerResponseModel findProducerById(Long id){
        LOGGER.info("Request to find producer by id - {}",id);
        Producer producer = producerRepository.findById(id)
                .orElseThrow(() -> new ProducerNotFoundException(String.format("Producer not found for id - {}%d",id)));
        ProducerResponseModel producerResponseModel = buildProducerResponseModelFrom(producer);
        LOGGER.info("Producer successfully be find by id - {}",producerResponseModel);
        return producerResponseModel;
    }

    public ProducerResponseModel update(Long id,ProducerRequestModel producerRequestModel){
        LOGGER.info("Request to update producer by id - {} - {}",id,producerRequestModel);
        Producer producerById = producerRepository.findById(id)
                .orElseThrow(() -> new ProducerNotFoundException(String.format("Producer not found for id - {}%d",id)));
        producerById.setName(producerRequestModel.getName());
        producerById.setSurname(producerRequestModel.getSurname());
        producerById.setAge(producerRequestModel.getAge());
        producerById.setProfession(producerRequestModel.getProfession());
        Producer updateProducer = producerRepository.save(producerById);
        ProducerResponseModel producerResponseModel = buildProducerResponseModelFrom(updateProducer);
        LOGGER.info("Producer successfully updated by id - {}",producerResponseModel);
        return producerResponseModel;
    }

    public void delete(Long id){
        LOGGER.info("Request to delete producer by id - {}",id);
        producerRepository.deleteById(id);
        LOGGER.info("Producer successfully deleted");
    }

    //endregion

    //region private Methods

    private Producer buildProducerFrom(ProducerRequestModel producerRequestModel){
        Producer producer = new Producer();
        producer.setName(producerRequestModel.getName());
        producer.setSurname(producerRequestModel.getSurname());
        producer.setAge(producerRequestModel.getAge());
        producer.setProfession(producerRequestModel.getProfession());
        return producer;
    }

    private ProducerResponseModel buildProducerResponseModelFrom(Producer producer){
        ProducerResponseModel producerResponseModel = new ProducerResponseModel();
        producerResponseModel.setId(producer.getId());
        producerResponseModel.setName(producer.getName());
        producerResponseModel.setSurname(producer.getSurname());
        producerResponseModel.setAge(producer.getAge());
        producerResponseModel.setProfession(producer.getProfession());
        return producerResponseModel;
    }

    //endregion
}
