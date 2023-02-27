package ru.aston.service;

import ru.aston.dto.worker.WorkerDtoRq;
import ru.aston.dto.worker.WorkerDtoRs;
import java.util.List;

public interface WorkerService {

    List<WorkerDtoRs> getAllWorker();

    void saveOrUpdateWorker(WorkerDtoRq workerDtoRq);

    WorkerDtoRs getWorkerById(Integer id);

    void deleteWorker(Integer id);
}
