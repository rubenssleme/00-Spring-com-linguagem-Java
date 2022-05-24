package avaliacao.hackathon.controller;


import com.nimbusds.oauth2.sdk.ErrorResponse;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/contest")
@ApiResponses({
    @ApiResponse(code = 500, message = "Internal Server Error"),
    @ApiResponse(code = 400, message = "Bad Request", response = ErrorResponse.class),
    @ApiResponse(code = 401, message = "Unauthorized", response = ErrorResponse.class),
    @ApiResponse(code = 403, message = "Forbidden", response = ErrorResponse.class)})
public class ContestController {


}
