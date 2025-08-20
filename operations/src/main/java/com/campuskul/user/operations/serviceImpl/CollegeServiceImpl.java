package com.campuskul.user.operations.serviceImpl;

import com.campuskul.user.operations.dto.CollegeRequestDTO;
import com.campuskul.user.operations.dto.CollegeResponseDTO;
import com.campuskul.user.operations.model.College;
import com.campuskul.user.operations.repository.CollegeRepository;
import com.campuskul.user.operations.service.CollegeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CollegeServiceImpl implements CollegeService {

    private final CollegeRepository collegeRepository;

    /**
     * Fetch all colleges
     */
    @Override
    public List<CollegeResponseDTO> getAllColleges() {
        List<College> colleges = collegeRepository.findAll();
        return colleges.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private String saveFile(MultipartFile file, String folder) throws IOException {
        if (file == null || file.isEmpty()) {
            return null;
        }

        String uploadDir = System.getProperty("user.dir") + File.separator + "uploads" + File.separator + folder;

        File dir = new File(uploadDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();

        File destination = new File(uploadDir + File.separator + fileName);
        file.transferTo(destination);


        return "/uploads/" + folder + "/" + fileName;
    }


    public CollegeResponseDTO addCollege(CollegeRequestDTO dto) throws IOException {
        College college = College.builder()
                .branchId(dto.getBranchId())
                .collegeName(dto.getCollegeName())
                .contactPersonName(dto.getContactPersonName())
                .personPost(dto.getPersonPost())
                .contactPersonNumber(dto.getContactPersonNumber())
                .contactPersonEmail(dto.getContactPersonEmail())
                .establishedYear(dto.getEstablishedYear())
                .addr1(dto.getAddr1())
                .addr2(dto.getAddr2())
                .addr3(dto.getAddr3())
                .zipcode(dto.getZipcode())
                .collegeLogo(saveFile(dto.getCollegeLogo(), "logos"))
                .collegeBanner(saveFile(dto.getCollegeBanner(), "banners"))
                .accrCertificate(saveFile(dto.getAccrCertificate(), "certificates"))
                .regCertificate(saveFile(dto.getRegCertificate(), "certificates"))
                .instituteProfile(saveFile(dto.getInstituteProfile(), "profiles"))
                .authLetter(saveFile(dto.getAuthLetter(), "authletters"))
                .privacy(saveFile(dto.getPrivacy(), "privacy"))
                .terms(saveFile(dto.getTerms(), "terms"))
                .listofcourse(dto.getListofcourse())
                .status(dto.getStatus())
                .createdby(1L) // get from logged-in user
                .createdate(LocalDateTime.now())
                .build();

        College saved = collegeRepository.save(college);
        return convertToDTO(college);
    }

    public CollegeResponseDTO editCollege(Long id, CollegeRequestDTO dto) throws IOException {
        College college = collegeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("College not found: " + id));

        college.setBranchId(dto.getBranchId());
        college.setCollegeName(dto.getCollegeName());
        college.setContactPersonName(dto.getContactPersonName());
        college.setPersonPost(dto.getPersonPost());
        college.setContactPersonNumber(dto.getContactPersonNumber());
        college.setContactPersonEmail(dto.getContactPersonEmail());
        college.setEstablishedYear(dto.getEstablishedYear());
        college.setAddr1(dto.getAddr1());
        college.setAddr2(dto.getAddr2());
        college.setAddr3(dto.getAddr3());
        college.setZipcode(dto.getZipcode());

        if (dto.getCollegeLogo() != null && !dto.getCollegeLogo().isEmpty()) {
            college.setCollegeLogo(saveFile(dto.getCollegeLogo(), "logos"));
        }
        if (dto.getCollegeBanner() != null && !dto.getCollegeBanner().isEmpty()) {
            college.setCollegeBanner(saveFile(dto.getCollegeBanner(), "banners"));
        }
        if (dto.getAccrCertificate() != null && !dto.getAccrCertificate().isEmpty()) {
            college.setAccrCertificate(saveFile(dto.getAccrCertificate(), "certificates"));
        }
        if (dto.getRegCertificate() != null && !dto.getRegCertificate().isEmpty()) {
            college.setRegCertificate(saveFile(dto.getRegCertificate(), "certificates"));
        }
        if (dto.getInstituteProfile() != null && !dto.getInstituteProfile().isEmpty()) {
            college.setInstituteProfile(saveFile(dto.getInstituteProfile(), "profiles"));
        }
        if (dto.getAuthLetter() != null && !dto.getAuthLetter().isEmpty()) {
            college.setAuthLetter(saveFile(dto.getAuthLetter(), "authletters"));
        }
        if (dto.getPrivacy() != null && !dto.getPrivacy().isEmpty()) {
            college.setPrivacy(saveFile(dto.getPrivacy(), "privacy"));
        }
        if (dto.getTerms() != null && !dto.getTerms().isEmpty()) {
            college.setTerms(saveFile(dto.getTerms(), "terms"));
        }
        college.setListofcourse(dto.getListofcourse());
        college.setStatus(dto.getStatus());
        college.setUpdatedby(dto.getUpdatedby());
        college.setUpdatedate(LocalDateTime.now());

        College updated = collegeRepository.save(college);
        return convertToDTO(updated);
    }

    public CollegeResponseDTO deleteCollege(Long id){
        College college = collegeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("College not found: " + id));

        college.setStatus(0);
        return convertToDTO(collegeRepository.save(college));
    }

    public CollegeResponseDTO getCollegeById(Long id){
        return convertToDTO(collegeRepository.findById(id).orElseThrow(()->new RuntimeException("College not found: " + id)));
    }
    private CollegeResponseDTO convertToDTO(College college) {
        CollegeResponseDTO dto = new CollegeResponseDTO();
        dto.setId(college.getId());
        dto.setBranchId(college.getBranchId());
        dto.setCollegeName(college.getCollegeName());
        dto.setContactPersonName(college.getContactPersonName());
        dto.setPersonPost(college.getPersonPost());
        dto.setContactPersonNumber(college.getContactPersonNumber());
        dto.setContactPersonEmail(college.getContactPersonEmail());
        dto.setEstablishedYear(college.getEstablishedYear());
        dto.setAddr1(college.getAddr1());
        dto.setAddr2(college.getAddr2());
        dto.setAddr3(college.getAddr3());
        dto.setZipcode(college.getZipcode());
        dto.setCollegeLogo(college.getCollegeLogo());
        dto.setCollegeBanner(college.getCollegeBanner());
        dto.setAccrCertificate(college.getAccrCertificate());
        dto.setRegCertificate(college.getRegCertificate());
        dto.setInstituteProfile(college.getInstituteProfile());
        dto.setContactInfo(college.getContactInfo());
        dto.setAuthLetter(college.getAuthLetter());
        dto.setPrivacy(college.getPrivacy());
        dto.setTerms(college.getTerms());
        dto.setListofcourse(college.getListofcourse());
        dto.setStatus(college.getStatus());
        dto.setCreatedby(college.getCreatedby());
        dto.setCreatedate(college.getCreatedate());
        dto.setUpdatedby(college.getUpdatedby());
        dto.setUpdatedate(college.getUpdatedate());
        return dto;
    }
//    private College convertToEntity(CollegeRequestDTO requestDTO) {
//        return College.builder()
//                .branchId(requestDTO.getBranchId())
//                .collegeName(requestDTO.getCollegeName())
//                .contactPersonName(requestDTO.getContactPersonName())
//                .personPost(requestDTO.getPersonPost())
//                .contactPersonNumber(requestDTO.getContactPersonNumber())
//                .contactPersonEmail(requestDTO.getContactPersonEmail())
//                .establishedYear(requestDTO.getEstablishedYear())
//                .addr1(requestDTO.getAddr1())
//                .addr2(requestDTO.getAddr2())
//                .addr3(requestDTO.getAddr3())
//                .zipcode(requestDTO.getZipcode())
//                .collegeLogo(requestDTO.getCollegeLogo())
//                .collegeBanner(requestDTO.getCollegeBanner())
//                .accrCertificate(requestDTO.getAccrCertificate())
//                .regCertificate(requestDTO.getRegCertificate())
//                .instituteProfile(requestDTO.getInstituteProfile())
//                .contactInfo(requestDTO.getContactInfo())
//                .authLetter(requestDTO.getAuthLetter())
//                .privacy(requestDTO.getPrivacy())
//                .terms(requestDTO.getTerms())
//                .listofcourse(requestDTO.getListofcourse())
//                .status(requestDTO.getStatus())
//                .createdby(requestDTO.getCreatedby())
//                .createdate(requestDTO.getCreatedate())
//                .updatedby(requestDTO.getUpdatedby())
//                .updatedate(requestDTO.getUpdatedate())
//                .build();
//    }
}
