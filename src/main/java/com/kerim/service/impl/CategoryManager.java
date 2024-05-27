package dev.kerim.service.impl;

import dev.kerim.service.abstracts.ICategoryServices;
import dev.kerim.core.expection.NotFoundException;
import dev.kerim.core.utilities.Message;
import dev.kerim.dao.CategoryRepository;
import dev.kerim.entities.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryManager implements ICategoryServices {
    private final CategoryRepository categoryRepository;
    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category update(Category category) {
        getId(category.getId());
        return categoryRepository.save(category);
    }

    @Override
    public Category getId(long id) {
        return categoryRepository.findById(id).orElseThrow(()-> new NotFoundException(Message.NOT_FOUND_MESSAGE));
    }

    @Override
    public Page<Category> cursor(int page, int pageSize) {
        return categoryRepository.findAll(PageRequest.of(page,pageSize));
    }

    @Override
    public boolean delete(long id) {
        categoryRepository.delete(getId(id));
        return true;
    }
}