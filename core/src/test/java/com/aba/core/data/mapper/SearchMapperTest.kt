package com.aba.core.data.mapper

import com.aba.core.SOME_SEARCH_RESPONSE_ITEMS
import com.aba.core.SOME_SEARCH_MODELS
import com.aba.core.domain.model.SearchModel
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SearchMapperTest {

    private lateinit var result: List<SearchModel>

    @InjectMocks
    lateinit var subject: SearchMapper

    @Test
    fun `whenMap thenTVSearchResponseListIsMappedToSearchModelList`() {
        whenMap()
        thenTVSearchResponseListIsMappedToSearchModelList()
    }

    /*
     * When
     */
    private fun whenMap() {
        result = subject.map(SOME_SEARCH_RESPONSE_ITEMS)
    }

    /*
     * Then
     */
    private fun thenTVSearchResponseListIsMappedToSearchModelList() =
        assertThat(result).isEqualTo(SOME_SEARCH_MODELS)
}