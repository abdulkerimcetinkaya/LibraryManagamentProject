package dev.kerim.service.impl;

import dev.kerim.service.abstracts.IPublisherServices;
import dev.kerim.core.expection.NotFoundException;
import dev.kerim.core.utilities.Message;
import dev.kerim.dao.PublisherRepository;
import dev.kerim.entities.Publisher;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PublisherManager implements IPublisherServices {
    private final PublisherRepository publisherRepository;
    @Override
    public Publisher save(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @Override
    public Publisher update(Publisher publisher) {
        getId(publisher.getId());
        return publisherRepository.save(publisher);
    }

    @Override
    public Publisher getId(long id) {
        return publisherRepository.findById(id).orElseThrow(() -> new NotFoundException(Message.NOT_FOUND_MESSAGE));
    }

    @Override
    public Page<Publisher> cursor(int page, int pageSize) {
        return publisherRepository.findAll(PageRequest.of(page,pageSize));
    }

    @Override
    public boolean delete(long id) {
        publisherRepository.delete(getId(id));
        return true;
    }
}