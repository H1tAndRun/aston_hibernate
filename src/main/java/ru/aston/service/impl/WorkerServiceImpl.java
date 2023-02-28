package ru.aston.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.aston.dao.WorkerDao;
import ru.aston.dto.worker.WorkerDtoRq;
import ru.aston.dto.worker.WorkerDtoRs;
import ru.aston.mapper.WorkerMapper;
import ru.aston.service.WorkerService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkerServiceImpl implements WorkerService {

    private final WorkerDao workerDao;

    private final WorkerMapper workerMapper;

    @Autowired
    public WorkerServiceImpl(WorkerDao workerDao, WorkerMapper workerMapper) {
        this.workerDao = workerDao;
        this.workerMapper = workerMapper;
    }

    public List<WorkerDtoRs> getAllWorker() {
        return workerDao.getAllWorker()
                .stream()
                .map(workerMapper::castFromEntity)
                .collect(Collectors.toList());
    }

    public void saveOrUpdateWorker(WorkerDtoRq workerDtoRq) {
        workerDao.saveOrUpdateWorker(workerMapper.castFromDtoRq(workerDtoRq));
    }

    public WorkerDtoRs getWorkerById(Integer id) {
        return workerMapper.castFromEntity(workerDao.getWorkerById(id));
    }

    public void deleteWorker(Integer id) {
        workerDao.deleteWorker(id);
    }
}
