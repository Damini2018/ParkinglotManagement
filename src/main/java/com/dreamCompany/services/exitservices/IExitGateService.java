package com.dreamCompany.services.exitservices;

import com.dreamCompany.Models.Ticket;
import com.dreamCompany.Models.Vehicle;

public interface IExitGateService {
    Ticket letGoVehicle(Vehicle vehicle);

    Ticket letGoVehicle(Ticket ticket);
}
