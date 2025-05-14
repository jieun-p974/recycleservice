package com.project.recycleservice.domain.entity

import jakarta.persistence.*

@Entity
@Table(name = "recycle_location_item")
class RecycleLocationItem(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne
    @JoinColumn(name = "location_id") // recycleItem 외래키 칼럼명 location_id
    val location: RecycleLocation,

    @ManyToOne
    @JoinColumn(name = "item_id") // supportedItem 외래키 칼럼명 item_id
    val item: SupportedItem
) {
}