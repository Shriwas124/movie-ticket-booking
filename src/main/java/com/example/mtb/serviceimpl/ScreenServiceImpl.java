package com.example.mtb.serviceimpl;

import com.example.mtb.dto.request.ScreenRequest;
import com.example.mtb.dto.response.ScreenResponse;
import com.example.mtb.dto.response.ScreenResponseList;
import com.example.mtb.dto.response.SeatResponse;
import com.example.mtb.entity.Screen;
import com.example.mtb.entity.Seat;
import com.example.mtb.entity.Theater;
import com.example.mtb.exception.ScreenIdNotFoundException;
import com.example.mtb.exception.TheaterOwnerIdException;
import com.example.mtb.repository.ScreenRepository;
import com.example.mtb.repository.TheaterRepository;
import com.example.mtb.service.ScreenService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class ScreenServiceImpl implements ScreenService {

    private final ScreenRepository screenRepository;
    private final TheaterRepository theaterRepository;
    private final SeatServiceImpl seatService;


    @Override
    public ScreenResponse addScreen(String theaterId, ScreenRequest screenRequest) {
        Optional<Theater> theaterOptional = theaterRepository.findById(theaterId);

        if (theaterOptional.isEmpty()){
            throw new TheaterOwnerIdException("Theater is not Found with "+theaterId);
        }else {
            Theater theater = theaterOptional.get();
            Screen screen = new Screen();

            screen.setScreenType(screenRequest.screenType());
            screen.setCapacity(screenRequest.capacity());
            screen.setNoOfRows(screenRequest.noOfRows());
            screen.setTheater(theater);

            List<Screen> screens = new ArrayList<>();
            screens.add(screen);
            theater.setScreen(screens);

            theaterRepository.save(theater);
            screenRepository.save(screen);

            seatService.generateSeatLayout(screen);

            return new ScreenResponse(
                    screen.getScreenType(),
                    screen.getCapacity(),
                    screen.getNoOfRows()
            );
        }
    }

    @Override
    public ScreenResponseList findScreen(String screenId) {
        Optional<Screen> optionalScreen = screenRepository.findById(screenId);

        if (optionalScreen.isEmpty()){
            throw new ScreenIdNotFoundException("Screen Id Not Found ");
        }else {
            Screen screen = optionalScreen.get();
            List<Seat> seatList = screen.getSeat();

            if (seatList == null){
                seatList = new ArrayList<>();
            }

            System.out.println("Found screen: " + screen.getScreenType());
            System.out.println("Seats: " + seatList.size());
            seatList.forEach(seat -> System.out.println(seat.getSeatName()));

            List<SeatResponse> seatResponses = seatList.stream().map(seat -> new SeatResponse(seat.getSeatId(),seat.getSeatName())).toList();



            return new ScreenResponseList(
                    screen.getScreenType(),
                    screen.getCapacity(),
                    screen.getNoOfRows(),
                    seatResponses
            );
        }
    }
    }


