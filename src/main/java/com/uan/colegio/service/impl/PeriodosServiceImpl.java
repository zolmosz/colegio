package com.uan.colegio.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.uan.colegio.commons.impl.GenericServiceImpl;
import com.uan.colegio.dao.PeriodosDao;
import com.uan.colegio.dto.ColegiosDto;
import com.uan.colegio.dto.PeriodosDto;
import com.uan.colegio.entity.Periodos;
import com.uan.colegio.service.PeriodosService;
import com.uan.colegio.utils.MHelpers;

@Service
public class PeriodosServiceImpl extends GenericServiceImpl<Periodos, UUID> implements PeriodosService {

    @Autowired
	private PeriodosDao periodosDao;


    @Override
    public List<PeriodosDto> findAll() {
        List<PeriodosDto> listaPeriodosDto = new ArrayList<>();

		Iterable<Periodos> periodosItr = this.periodosDao.findAll();

		for (Periodos periodos : periodosItr) {

			PeriodosDto periodosDto = new PeriodosDto();
			periodosDto = MHelpers.modelMapper().map(periodos, PeriodosDto.class);
            periodosDto.setColegiosDto(MHelpers.modelMapper().map(periodos.getColegios(), ColegiosDto.class));
			listaPeriodosDto.add(periodosDto);
		}

		return listaPeriodosDto;
    }

    @Override
    public PeriodosDto findByid(UUID id) {
        Optional<Periodos> periodos = this.periodosDao.findById(id);
		PeriodosDto periodosDto = MHelpers.modelMapper().map(periodos.get(), PeriodosDto.class);
        periodosDto.setColegiosDto(MHelpers.modelMapper().map(periodos.get().getColegios(), ColegiosDto.class));

		return periodosDto;
    }

    @Override
    public PeriodosDto save(PeriodosDto PeriodosDto) {
        Periodos Periodos = MHelpers.modelMapper().map(PeriodosDto, Periodos.class);

		Periodos = this.periodosDao.save(Periodos);
		PeriodosDto = MHelpers.modelMapper().map(Periodos, PeriodosDto.class);

		return PeriodosDto;
    }

    @Override
    public void delete(PeriodosDto PeriodosDto) {
        Periodos Periodos = MHelpers.modelMapper().map(PeriodosDto, Periodos.class);
		this.periodosDao.delete(Periodos);
    }

    @Override
    public void deleteById(UUID id) {
        periodosDao.deleteById(id);
    }

    @Override
    public CrudRepository<Periodos, UUID> getDao() {
        return periodosDao;
    }
    
}
