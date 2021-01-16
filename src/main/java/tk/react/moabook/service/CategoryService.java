package tk.react.moabook.service;

import tk.react.moabook.domain.Category;

public interface CategoryService {

    void save(Category category);
    void findOne(Long id);

}
