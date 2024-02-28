package com.boyslab.ads.dataAccess;

import com.boyslab.ads.entities.SuspendedHelpImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SuspendedHelpImageRepository extends JpaRepository<SuspendedHelpImage,Integer> {

    //Optional<SuspendedHelpImage> findBySuspendedHelp_Id(int id);

    List<SuspendedHelpImage> findAllBySuspendedHelp_Id(int id);


}
