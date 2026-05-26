package k23cnt2.nhom4.prj4.ttcd.service;

import k23cnt2.nhom4.prj4.ttcd.entity.Category;
import k23cnt2.nhom4.prj4.ttcd.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    // lấy tất cả danh mục
    public List<Category> getAllCategories() {

        return categoryRepository.findAll();
    }

    // lấy theo id
    public Category getCategoryById(Integer id) {

        return categoryRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Không tìm thấy danh mục"
                        ));
    }

    // thêm
    public Category createCategory(Category category) {

        return categoryRepository.save(category);
    }

    // sửa
    public Category updateCategory(
            Integer id,
            Category newCategory
    ) {

        Category oldCategory =
                getCategoryById(id);

        oldCategory.setName(newCategory.getName());

        oldCategory.setSlug(newCategory.getSlug());

        oldCategory.setImageUrl(
                newCategory.getImageUrl()
        );

        return categoryRepository.save(oldCategory);
    }

    // xóa
    public void deleteCategory(Integer id) {

        categoryRepository.deleteById(id);
    }
}