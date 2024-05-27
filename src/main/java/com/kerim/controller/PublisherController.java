package dev.kerim.controller;

import dev.kerim.service.abstracts.IPublisherServices;
import dev.kerim.core.result.Result;
import dev.kerim.core.result.ResultData;
import dev.kerim.core.utilities.ResultHelper;
import dev.kerim.dto.request.publisher.PublisherSaveRequest;
import dev.kerim.dto.request.publisher.PublisherUpdateRequest;
import dev.kerim.dto.response.CursorResponse;
import dev.kerim.dto.response.publisher.PublisherResponse;
import dev.kerim.entities.Publisher;
import dev.seyma.springbootlibrarymanagement.v1.core.config.ModelMapper.ModelMapperServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/publishers")
@RequiredArgsConstructor
public class PublisherController {
    private final IPublisherServices publisherServices;
    private final ModelMapperServices mapperService;

    @GetMapping("{id}")
    public ResultData<PublisherResponse> getId(@PathVariable long id){
        PublisherResponse publisherResponse = mapperService.forResponse().map(publisherServices.getId(id),PublisherResponse.class);
        return ResultHelper.OK(publisherResponse);
    }
    @PostMapping
    public ResultData<PublisherResponse> save(@Valid @RequestBody PublisherSaveRequest publisherSaveRequest){
        PublisherResponse publisherResponse = mapperService.forResponse().map(publisherServices.save(mapperService.forRequest().map(publisherSaveRequest, Publisher.class)),PublisherResponse.class);
        return ResultHelper.CREATED(publisherResponse);
    }
    @PutMapping
    public ResultData<PublisherResponse> update(@Valid @RequestBody PublisherUpdateRequest publisherUpdateRequest){
        PublisherResponse publisherResponse = mapperService.forResponse().map(publisherServices.update(mapperService.forRequest().map(publisherUpdateRequest, Publisher.class)),PublisherResponse.class);
        return ResultHelper.CREATED(publisherResponse);
    }
    @DeleteMapping("{id}")
    public Result delete(@PathVariable long id){
        return ResultHelper.OK(publisherServices.delete(id));
    }
    @GetMapping
    public ResultData<CursorResponse<PublisherResponse>> cursor(@RequestParam(name = "page", required = false, defaultValue = "0") int page, @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
        Page<Publisher> publishers = publisherServices.cursor(page,pageSize);
        Page<PublisherResponse> publisherResponses = publishers.map(category -> mapperService.forResponse().map(category,PublisherResponse.class));
        return ResultHelper.cursor(publisherResponses);
    }


}