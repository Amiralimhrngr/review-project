package ir.nas.service;

import ir.nas.command.UserInfoDaoToUserInfoResponseDto;
import ir.nas.command.UserInfoRequestDtoTOUserInfoDao;
import ir.nas.dao.UserInfoDAO;
import ir.nas.dto.UserInfoRequestDTO;
import ir.nas.dto.UserInfoResponseDTO;
import ir.nas.repository.UserInfoRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class UserInfoService
{
    private final UserInfoRepository repository;

    public UserInfoResponseDTO create(UserInfoRequestDTO userInfoRequestDTO)
    {
        UserInfoDAO userInfoDAO = this.repository.create(
                UserInfoRequestDtoTOUserInfoDao.convert(userInfoRequestDTO));

        return UserInfoDaoToUserInfoResponseDto.convert(userInfoDAO);
    }



    public List<UserInfoResponseDTO> findAll() {
        return this.repository.findAll()
                .stream()
                .map(UserInfoDaoToUserInfoResponseDto::convert)
                .toList();
    }
}
