package api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumberController {
    @PostMapping("/calculateLargestNumber")
    public int calculateLargestNumber(@RequestBody int[] inputArray) {
        //LargestPossibleNumber obj = new LargestPossibleNumber();
        //return obj.calculateLargestPossibleNumber(inputArray);
        return 0;
    }
}

