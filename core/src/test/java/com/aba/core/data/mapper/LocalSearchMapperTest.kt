package com.aba.core.data.mapper

import com.aba.core.SOME_LOCAL_SEARCH_MODEL
import com.aba.core.SOME_LOCAL_SEARCH_MODELS
import com.aba.core.SOME_SEARCH_MODEL
import com.aba.core.SOME_SEARCH_MODELS
import com.aba.core.data.local.model.LocalSearchModel
import com.aba.core.domain.model.SearchModel
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class LocalSearchMapperTest {

    lateinit var result: List<SearchModel>
    lateinit var localResult: List<LocalSearchModel>

    @InjectMocks
    lateinit var subject: LocalSearchMapper

    @Test
    fun `givenLocalSearchModel whenMapFromLocalToGeneral thenLocalDataIsMapped`() {
        whenMapFromLocalToGeneral()
        thenLocalDataIsMapped()
    }

    @Test
    fun `givenSearchModel whenMapFromGeneralToLocal thenGeneralDataIsMapped`() {
        whenMapFromGeneralToLocal()
        thenGeneralDataIsMapped()
    }


    /*
     * When
     */
    private fun whenMapFromLocalToGeneral() {
        result = subject.mapFromLocal(SOME_LOCAL_SEARCH_MODELS)
    }

    private fun whenMapFromGeneralToLocal() {
        localResult = subject.mapToLocal(SOME_SEARCH_MODELS)
    }

    /*
     * Then
     */
    private fun thenLocalDataIsMapped() = with(result[0]) {
        assertThat(name).isEqualTo(SOME_SEARCH_MODEL.name)
        assertThat(id).isEqualTo(SOME_SEARCH_MODEL.id)
        assertThat(score).isEqualTo(SOME_SEARCH_MODEL.score)
        assertThat(genres).isEqualTo(SOME_SEARCH_MODEL.genres)
        assertThat(language).isEqualTo(SOME_SEARCH_MODEL.language)
        assertThat(officialSite).isEqualTo(SOME_SEARCH_MODEL.officialSite)
        assertThat(status).isEqualTo(SOME_SEARCH_MODEL.status)
        assertThat(type).isEqualTo(SOME_SEARCH_MODEL.type)
        assertThat(url).isEqualTo(SOME_SEARCH_MODEL.url)
        assertThat(mediumImage).isEqualTo(SOME_SEARCH_MODEL.mediumImage)
        assertThat(originalImage).isEqualTo(SOME_SEARCH_MODEL.originalImage)
        assertThat(averageRating).isEqualTo(SOME_SEARCH_MODEL.averageRating)
    }

    private fun thenGeneralDataIsMapped() = with(localResult[0]) {
        assertThat(name).isEqualTo(SOME_LOCAL_SEARCH_MODEL.name)
        assertThat(id).isEqualTo(SOME_LOCAL_SEARCH_MODEL.id)
        assertThat(score).isEqualTo(SOME_LOCAL_SEARCH_MODEL.score)
        assertThat(genres).isEqualTo(SOME_LOCAL_SEARCH_MODEL.genres)
        assertThat(language).isEqualTo(SOME_LOCAL_SEARCH_MODEL.language)
        assertThat(officialSite).isEqualTo(SOME_LOCAL_SEARCH_MODEL.officialSite)
        assertThat(status).isEqualTo(SOME_LOCAL_SEARCH_MODEL.status)
        assertThat(type).isEqualTo(SOME_LOCAL_SEARCH_MODEL.type)
        assertThat(url).isEqualTo(SOME_LOCAL_SEARCH_MODEL.url)
        assertThat(mediumImage).isEqualTo(SOME_LOCAL_SEARCH_MODEL.mediumImage)
        assertThat(originalImage).isEqualTo(SOME_LOCAL_SEARCH_MODEL.originalImage)
        assertThat(averageRating).isEqualTo(SOME_LOCAL_SEARCH_MODEL.averageRating)
    }
}