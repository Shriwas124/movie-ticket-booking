package com.example.mtb.serviceimpl;

import com.example.mtb.dto.request.FeedbackRequest;
import com.example.mtb.dto.response.FeedbackResponse;
import com.example.mtb.entity.Feedback;
import com.example.mtb.entity.Movie;
import com.example.mtb.entity.User;
import com.example.mtb.exception.MovieNotFoundByIdException;
import com.example.mtb.exception.UserDetailsNotFoundException;
import com.example.mtb.repository.FeedbackRepository;
import com.example.mtb.repository.MovieRepository;
import com.example.mtb.repository.UserDetailsRepository;
import com.example.mtb.repository.UserRepository;
import com.example.mtb.service.FeedbackService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FeedbackServiceImpl implements FeedbackService {
    private final MovieRepository movieRepository;
    private final UserDetailsRepository userDetailsRepository;
    private final FeedbackRepository feedbackRepository;
    private final UserRepository userRepository;


    @Override
    public FeedbackResponse createFeedBack(FeedbackRequest feedback, String userId, String movieId) {

        Optional<User> optionalUser=userRepository.findById(userId);
        if(optionalUser.isPresent()){
            Optional<Movie> optionalMovie=movieRepository.findById(movieId);
            if (optionalMovie.isPresent()){


                User user=optionalUser.get();
                Movie movie=optionalMovie.get();

                Feedback newFeedback=new Feedback();
                newFeedback.setRating(feedback.rating());
                newFeedback.setReview(feedback.review());
                newFeedback.setCreatedAt((Instant.ofEpochMilli(System.currentTimeMillis())));
                newFeedback.setUser(user);
                newFeedback.setMovie(movie);

                List<Feedback> feedbackList=new ArrayList<>();
                feedbackList.add(newFeedback);

                movie.setFeedbackList(feedbackList);
                user.setFeedbackList(feedbackList);

                movieRepository.save(movie);
                userRepository.save(user);

                Feedback savedFeedback=feedbackRepository.save(newFeedback);

//                Movie updatedMovie=movieRepository.findById(movieId).get();
//
//                List<Feedback> newFeadFeedbackList=updatedMovie.getFeedbackList();
//                int noOfFeadback = 0;
//                int totalRatings=0;
//                for (Feedback ratingsListFeadBack : newFeadFeedbackList){
//                    noOfFeadback++;
//                    totalRatings=totalRatings+ratingsListFeadBack.getRatings();
//                }
//                System.out.println("no of feadback    "+noOfFeadback);
//                System.out.println("total ratings    "+totalRatings);
//
//
//                double avgRatings;
//                if (noOfFeadback==0){
//                    avgRatings=0;
//                }else {
//                   avgRatings= totalRatings/noOfFeadback;
//                }


                return new FeedbackResponse(
                        savedFeedback.getRating(),
                        savedFeedback.getReview()

                );

            }else{
                throw new MovieNotFoundByIdException("movie not found by this Id");
            }
        }else {
            throw new UserDetailsNotFoundException("User not found by Id Excaption");
        }
    }
}




