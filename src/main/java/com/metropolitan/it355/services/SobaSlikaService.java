package com.metropolitan.it355.services;

import com.metropolitan.it355.entity.SobaSlika;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface SobaSlikaService {

    /**
     * Metoda vraca sve slike sobe
     * @return List<SobaSlika>
     */
    List<SobaSlika> getAll();

    /**
     * Metoda vraca jednog sliku po ID
     * @param id
     * @return SobaSlika
     */
    Optional<?> getById(int id);

    /**
     * Metoda dodaje jednu sliku u bazu
     * @param sobaSlika
     * @return SobaSlika
     */
    SobaSlika add(SobaSlika sobaSlika);

    /**
     * Metoda update-uje sobu u bazu
     * @param sobaSlika
     * @return SobaSlika
     */
    SobaSlika update(SobaSlika sobaSlika);

    /**
     * Metoda brise sliku iz baze po ID
     * @param id
     */
    void delete(int id);

    /**
     * Metoda vraca sve slike za odredjenu sobu po ID
     * @param idSoba
     * @return List<SobaSlika>
     */
    List<SobaSlika> getAllByIdSoba(Integer idSoba);

    /**
     * Metoda cuva vise slika za jedan smestaj
     * @param sobaSlikaId
     * @param imageUrl
     */
    void savePhotos(int sobaSlikaId, String imageUrl);

    /**
     * Metoda uploaduje slike
     * @param images
     * @param sobaId
     * @return Map<String,String>
     */
    Map<String, String> uploadImages(MultipartFile[] images, int sobaId);

    /**
     * Metoda brise sliku iz foldera po id
     * @param id
     */
    void deleteSobaSlika(int id);
}
