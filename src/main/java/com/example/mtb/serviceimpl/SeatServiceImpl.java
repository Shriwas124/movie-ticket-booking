package com.example.mtb.serviceimpl;

import com.example.mtb.entity.Screen;
import com.example.mtb.entity.Seat;
import com.example.mtb.repository.ScreenRepository;
import com.example.mtb.repository.SeatRepository;
import com.example.mtb.service.SeatService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class SeatServiceImpl implements SeatService {
    private final SeatRepository seatRepository;
    private final ScreenRepository screenRepository;

    @Override
    @Transactional
    public void generateSeatLayout(Screen screen) {
        Screen existingScreen = screenRepository.findById(screen.getScreenId())
                .orElseThrow(() -> new RuntimeException("Screen not found"));

        int noOfRows = screen.getNoOfRows();
        int seatsPerRow = screen.getCapacity() / noOfRows;

        List<Seat> seatList = new ArrayList<>();
        char rowName = 'A';

        for (int i = 1; i <= noOfRows; i++) {
            for (int j = 1; j <= seatsPerRow; j++) {
                Seat newSeat = new Seat();
                newSeat.setSeatName(rowName + String.valueOf(j));
                newSeat.setCreatedAt(System.currentTimeMillis());
                newSeat.setScreen(existingScreen);
                seatList.add(newSeat);
            }
            rowName++;
        }

        seatRepository.saveAll(seatList);
        existingScreen.setSeat(seatList);
        screenRepository.save(existingScreen);
    }
}

