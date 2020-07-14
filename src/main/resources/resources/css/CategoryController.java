package resources.css;

import com.yemmback.store.model.Category;
import com.yemmback.store.payload.reponse.ApiResponse;
import com.yemmback.store.payload.request.CategoryRequest;
import com.yemmback.store.repository.CategoryRepository;
import com.yemmback.store.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.constraints.Min;
import java.net.URI;
import java.util.List;
/*
public class CategoryController {
/*
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryService categoryService;

    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);


    // Find
    @GetMapping("/categorys")
    List<CategoryRequest> findAll() {
        return categoryService.getAllCategorys();
    }


    // Find
    @GetMapping("/category/{id}")
    CategoryRequest findOne(@PathVariable @Min(1) Long id) { return (id>0)?categoryService.getCategory(id):null; }
    // Find
    @GetMapping("/category/{categoryname}")
    CategoryRequest findOnebyname(@PathVariable String categoryname) { return categoryService.findCategory(categoryname); }

    // Save or update
    @PutMapping("/category")
    ResponseEntity<?> saveOrUpdate(@RequestBody CategoryRequest newCategory) {

        Category category= new Category();

        if(newCategory.getId()==null){
            if(categoryRepository.existsByCategoryname(newCategory.getCategoryname())) {
                return new ResponseEntity(new ApiResponse(false, "Categoryname is already taken!"),
                        HttpStatus.BAD_REQUEST);
            }

              category = new Category(null, newCategory.getCategoryname(),0, null) ;
        }else {
            category=categoryRepository.getOne(newCategory.getId());
            if(category.getId()>0){
                category.setCategoryname(newCategory.getCategoryname());
                category.setFlag(newCategory.getFlag());
            }
        }



        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/categorys/{categoryname}")
                .buildAndExpand(categoryRepository.save(category).getCategoryname()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "Category saved successfully "+String.valueOf(category.getId())));
      //  return ResponseEntity.created(location).body(new ApiResponse(true, "Category saved successfully",category));
    }

    // Find
    @GetMapping("/delcategory/{id}")
    ResponseEntity<?> delete(@PathVariable @Min(1) Long id) {

       Category category=categoryRepository.getOne(id);category.setFlag(1);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/categorys/{categoryname}")
                .buildAndExpand(categoryRepository.save(category).getCategoryname()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "Category "+String.valueOf(id)+" successfully deleted "));
    }
*/
}
