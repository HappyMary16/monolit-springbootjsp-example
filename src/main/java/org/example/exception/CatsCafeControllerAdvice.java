package org.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CatsCafeControllerAdvice {

    @ExceptionHandler(value = DuplicatingNameException.class)
    public ModelAndView duplicateNameException(DuplicatingNameException e) {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("catName", e.getCat().getName());
        modelAndView.addObject("message", "Не можна додати кота з вже існуючим іменем");
        modelAndView.setViewName("error-cat");
        modelAndView.setStatus(HttpStatus.CONFLICT);
        return modelAndView;
    }

    @ExceptionHandler(value = CatNotFoundException.class)
    public ModelAndView catNotFoundException(CatNotFoundException e) {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("catName", e.getCatName());
        modelAndView.addObject("message", "Кота не знайдено");
        modelAndView.setViewName("error-cat");
        modelAndView.setStatus(HttpStatus.NOT_FOUND);
        return modelAndView;
    }
}
