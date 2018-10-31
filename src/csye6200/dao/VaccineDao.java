package csye6200.dao;
import csye6200.entity.Vaccine;
import java.util.List;
public interface VaccineDao {
    List<Vaccine> getAllVaccination();

    void updateVaccination(List<Vaccine> list);
}