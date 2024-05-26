package gokhan.cihan.Library.service;

import gokhan.cihan.Library.dto.request.AuthorRequest;
import gokhan.cihan.Library.dto.response.AuthorResponse;

import java.util.List;

public interface IAuthorService {

    AuthorResponse getById(Long id);

    List<AuthorResponse> getAll();

    AuthorResponse create(AuthorRequest authorRequest);

    AuthorResponse update(Long id, AuthorRequest authorRequest);

    void delete(Long id);

}
