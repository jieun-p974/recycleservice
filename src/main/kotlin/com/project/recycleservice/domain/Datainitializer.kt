package com.project.recycleservice.domain

import com.project.recycleservice.domain.entity.*
import com.project.recycleservice.domain.repository.*
import jakarta.annotation.PostConstruct
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component
import java.time.LocalDate
import java.time.LocalDateTime


@Component
@Profile(value = ["default"])
class Datainitializer (
    private val userRepository:UserRepository,
    private val recycleLocationRepository: RecycleLocationRepository,
    private val supportedItemRepository: SupportedItemRepository,
    private val recycleLocationItemRepository: RecycleLocationItemRepository,
    private val favoriteLocationRepository: FavoriteLocationRepository,
    private val reviewRepository: ReviewRepository
){
    @PostConstruct
    fun initializeData(){
        // User 초기화
        // userId 사용자id
        // email 이메일
        // password 비밀번호
        // nicknmae 닉네임
        // createdDte 계정 생성일
        // updateDte 계정 수정일
        val users = mutableListOf<User>(
            User(
                userId = "abc554",
                email = "",
                password = "",
                nickname = "",
                createdDte = LocalDateTime.of(2025,5,1,12,5),
                updateDte = null
            ),User(
                userId = "abx853",
                email = "",
                password = "",
                nickname = "",
                createdDte = LocalDateTime.of(2025,3,1,12,5),
                updateDte = LocalDateTime.of(2025,4,22,12,5)
            ),
        )
        userRepository.saveAll(users)
        // RecycleLocation 초기화
        // name 장소명
        // address 주소
        // latitude 경도
        // longitude 위도
        // provider 관리 주체
        // category 분리수거 카테고리
        // phoneNumber 연락처
        // createdDte 정보 등록일
        // updateDte 정보 수정일
        val recycleLocations = mutableListOf<RecycleLocation>(
            RecycleLocation(
                name = "어쩌고구 행정복지센터 전기차 충전소 옆",
                address = "서울시 어쩌고구 저쩌고동",
                latitude = 121.12,
                longitude = 1234.11,
                provider = "행정복지센터",
                category = "형광등",
                phoneNumber = "02-8888-7777",
                createdDte = LocalDateTime.of(2025,5,17,11,45),
                updateDte = LocalDateTime.now()
            ),
            RecycleLocation(
                name = "미래 아파트 관리사무소 옆",
                address = "충청남도 땡땡시 땡땡면",
                latitude = 1231.12,
                longitude = 124.11,
                provider = "미래 아파트",
                category = "헌옷",
                phoneNumber = "",
                createdDte = LocalDateTime.now(),
                updateDte = LocalDateTime.now()
            ),
            RecycleLocation(
                name = "행복약국",
                address = "경상북도 네모시 세모면",
                latitude = 521.12,
                longitude = 234.11,
                provider = "행복약국",
                category = "폐의약품",
                phoneNumber = "054-546-8888",
                createdDte = LocalDateTime.of(2025,3,1,15,10),
                updateDte = LocalDateTime.now()
            ),
        )
        recycleLocationRepository.saveAll(recycleLocations)
        // SupportedItem 초기화
        // itemId 물품 아이디
        // name 물품명
        val supportedItems = mutableListOf<SupportedItem>(
            SupportedItem(
                itemId = 1L,
                name = "형광등"
            ),
            SupportedItem(
                itemId = 2L,
                name = "폐건전지"
            ),
            SupportedItem(
                itemId = 3L,
                name = "헌옷"
            )
        )
        supportedItemRepository.saveAll(supportedItems)
        // RecycleLocationItem 초기화
        // id 아이디
        // recycleLocation
        // supportedItem
        val recycleLocationItems = mutableListOf<RecycleLocationItem>(

        )
        // FavoriteLocation 초기화
        // Review 초기화
    }
}