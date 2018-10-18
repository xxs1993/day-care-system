package dao;

import csye6200.entity.Registration;

import java.util.List;

public interface RegistrationDao {
    List<Registration> getAllRegistration();

    void updateRegistration(List<Registration> list);
}
