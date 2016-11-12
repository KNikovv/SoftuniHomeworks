package com.hoteldb.console;

import com.hoteldb.entities.*;
import com.hoteldb.service.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Console implements CommandLineRunner {

    @Autowired
    private BedTypeService bedTypeService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private OccupancyService occupancyService;
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private RoomService roomService;
    @Autowired
    private RoomStatusService roomStatusService;
    @Autowired
    private RoomTypeService roomTypeService;

    @Override
    public void run(String... strings) throws Exception {
        BedType bedType = new BedType();
        bedType.setRoomType("1");
        Customer customer = new Customer();
        customer.setFirstName("Pesho");
        customer.setLastName("Peshev");
        Employee employee = new Employee();
        employee.setFirstName("Gosho");
        employee.setLastName("Goshev");
        Occupancy occupancy = new Occupancy();
        occupancy.setId(1);
        occupancy.setAccountNumber(15);
        occupancy.setRoomNumber(1);
        occupancy.setDateOccupied(new Date());
        Payment payment = new Payment();
        payment.setId(1);
        payment.setAmountCharged(1000d);
        Room room = new Room();
        room.setRoomType("p");
        room.setRate(1.0);
        RoomStatus roomStatus = new RoomStatus();
        roomStatus.setId(1);
        roomStatus.setRoomStatus("ok");
        RoomType roomType = new RoomType();
        roomType.setId(1);
        room.setBedType("pp");
        bedTypeService.create(bedType);
        customerService.create(customer);
        employeeService.create(employee);
        occupancyService.create(occupancy);
        paymentService.create(payment);
        roomService.create(room);
        roomStatusService.create(roomStatus);
        roomTypeService.create(roomType);
    }
}
