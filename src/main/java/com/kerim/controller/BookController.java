package dev.kerim.controller;

import dev.kerim.core.result.Result;
import dev.kerim.core.result.ResultData;
import dev.kerim.service.abstracts.IBookServices;
import dev.seyma.springbootlibrarymanagement.v1.core.config.ModelMapper.ModelMapperServices;
import dev.kerim.core.utilities.ResultHelper;
import dev.kerim.dto.request.book.BookSaveRequest;
import dev.kerim.dto.response.CursorResponse;
import dev.kerim.entities.Book;


import dev.kerim.dto.response.book.BookResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/books")
@RequiredArgsConstructor
public class BookController {
    private final ModelMapperServices mapperService;
    private final IBookServices bookServices;

    @GetMapping("{id}")
    public ResultData<BookResponse> getId(@PathVariable long id){
        BookResponse bookResponse = mapperService.forResponse().map(bookServices.getId(id),BookResponse.class);
        return ResultHelper.OK(bookResponse);
    }
    @PostMapping
    public ResultData<BookResponse> save(@Valid @RequestBody BookSaveRequest bookSaveRequest){
        BookResponse bookResponse = mapperService.forResponse().map(bookServices.save(mapperService.forRequest().map(bookSaveRequest, Book.class)),BookResponse.class);
        return ResultHelper.CREATED(bookResponse);
    }
    @PutMapping
    public ResultData<BookResponse> update(@Valid @RequestBody BookUpdateRequest bookUpdateRequest){
        BookResponse bookResponse = mapperService.forResponse().map(bookServices.update(mapperService.forRequest().map(bookUpdateRequest, Book.class)),BookResponse.class);
        return ResultHelper.OK(bookResponse);
    }
    @DeleteMapping("{id}")
    public Result delete(@PathVariable long id){
        return ResultHelper.OK(bookServices.delete(id));
    }
    @GetMapping
    public ResultData<CursorResponse<BookResponse>> cursor(@RequestParam(name = "page", required = false, defaultValue = "0") int page, @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
        Page<Book> books = bookServices.cursor(page,pageSize);
        Page<BookResponse> bookResponses = books.map(category -> mapperService.forResponse().map(category,BookResponse.class));
        return ResultHelper.cursor(bookResponses);
    }

}