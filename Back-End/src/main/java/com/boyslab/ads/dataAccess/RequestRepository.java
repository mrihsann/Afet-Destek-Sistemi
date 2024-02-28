package com.boyslab.ads.dataAccess;

import com.boyslab.ads.dtos.response.request.RequestDetailDto;
import com.boyslab.ads.entities.Request;
import com.boyslab.ads.entities.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface RequestRepository extends JpaRepository<Request,String> {

    int countByTc(String tc);

    List<Request> findAllByStatus(Status status);

    @Query("select  new com.boyslab.ads.dtos.response.request.RequestDetailDto(r.name,r.surname,r.phone,c.name,c.description) " +
            "from Category  c INNER JOIN c.requests r")
    List<RequestDetailDto> getDetails();

    @Query("select  new com.boyslab.ads.dtos.response.request.RequestDetailDto(r.name,r.surname,r.phone,c.name,c.description) " +
            "from Category  c INNER JOIN c.requests r where  c.id =:categoryId")
    List<RequestDetailDto> getDetailsByCategoryId(@PathVariable("categoryId") int categoryId);



}
