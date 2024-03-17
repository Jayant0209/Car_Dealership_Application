package services;

import entities.Salesperson;

import java.util.List;

public interface SalespersonService {
    void addSalesperson(Salesperson salesperson);
    void updateSalesperson(Salesperson salesperson);
    void deleteSalesperson(long salespersonId);
    Salesperson getSalespersonById(long salespersonId);
    List<Salesperson> getAllSalespersons();
}
