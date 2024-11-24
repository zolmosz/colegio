package com.uan.colegio.controllers;

import java.util.NoSuchElementException;

import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import org.hibernate.exception.ConstraintViolationException;

import com.uan.colegio.exception.RequestException;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.PersistenceException;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandlerController {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ControllerAdvice.class);
	
	@ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ModelAndView runtimeExceptionHandler(RuntimeException ex){
		ModelAndView mav = new ModelAndView("layout/modalerror :: modal_error");

        mav.addObject("titulo", "Error en tiempo de ejecución");
        mav.addObject("mensaje", ex.getMessage());
        mav.addObject("detalles", "Se presento un erro en el momento de ejecución.");

        return mav;
	}
	
	@ExceptionHandler(RequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
	public ModelAndView requestExceptionHandler(RequestException ex){
		ModelAndView mav = new ModelAndView("layout/modalerror :: modal_error");

        mav.addObject("titulo", "Error en la solicitud");
        mav.addObject("mensaje", ex.getMessage());
        mav.addObject("detalles", "Se presento un error con la solicitud.");

        return mav;
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public RedirectView datosExceptionHandler(DataIntegrityViolationException ex, HttpServletRequest request, RedirectAttributes attributes){
        String mensajeError="";
        String referer = request.getHeader("Referer");

        if (ex.getCause() instanceof ConstraintViolationException) {
            ConstraintViolationException constraintEx = (ConstraintViolationException) ex.getCause();

            switch (constraintEx.getSQLState()) {
                case "23505":
                    mensajeError = "Error: ya existe un registro con estos valores únicos.";
                    break;
            
                default:
                    mensajeError = "Error de integridad de datos.";
                    break;
            }
        }

        attributes.addFlashAttribute("error", mensajeError);


        return new RedirectView(referer);
	}

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView constraintExceptionHandler(ConstraintViolationException ex){
        ModelAndView mav = new ModelAndView("layout/modalerror :: modal_error");

        mav.addObject("titulo", "Error de datos");
        mav.addObject("mensaje", ex.getMessage());
        mav.addObject("detalles", "Se presento una violación de restricción de datos.");

        return mav;

    }

    @ExceptionHandler(PersistenceException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView persistenceExceptionHandler(PersistenceException ex){
        ModelAndView mav = new ModelAndView("layout/modalerror :: modal_error");

        mav.addObject("titulo", "Error de datos");
        mav.addObject("mensaje", ex.getMessage());
        mav.addObject("detalles", "Se presento un error de persistencia de datos.");

        return mav;

    }

    @ExceptionHandler(EntityExistsException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView entityExistsExceptionHandler(EntityExistsException ex){
        ModelAndView mav = new ModelAndView("layout/modalerror :: modal_error");

        mav.addObject("titulo", "Error de datos");
        mav.addObject("mensaje", ex.getMessage());
        mav.addObject("detalles", "Se presento un error con la entidad.");

        return mav;

    }
	
	@ExceptionHandler(value=NoSuchElementException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ModelAndView datosNoEncontradosExceptionHandler(NoSuchElementException ex){
		ModelAndView mav = new ModelAndView("layout/modalerror :: modal_error");

        mav.addObject("titulo", "Error de datos");
        mav.addObject("mensaje", ex.getMessage());
        mav.addObject("detalles", "Se presento un error con la entidad.");

        return mav;
	}
}
