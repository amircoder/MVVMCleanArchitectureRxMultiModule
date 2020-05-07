package com.aba.core.data.local.dao

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
import com.aba.core.*
import com.aba.core.data.local.AppDataBase
import com.aba.core.data.local.model.LocalSearchModel
import com.aba.core.data.mapper.LocalSearchMapper
import com.aba.core.data.model.TVSearchResponse
import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SearchDaoTest {

    private lateinit var database: AppDataBase
    private lateinit var subject: SearchDao
    private lateinit var result: List<LocalSearchModel>

    @Before
    fun setup() {
        database = AppDataBase.getTestInstance(InstrumentationRegistry.getInstrumentation().targetContext)
        subject = database.getSearchDao()
    }

    @After
    fun tearDown(){
        database.close()
    }

    @Test
    fun `whenOnInsert AndWhenGetSearchResults thenResultIsSuccessful`(){
        whenOnInsert()
        whenGetSearchResults()
        thenResultIsSuccessful()
    }

    @Test
    fun `whenEmptyDatabase AndWhenGetSearchResults thenResultIsEmpty`(){
        whenGetSearchResults()
        thenResultIsEmpty()
    }


    /*
     * When
     */
    private fun whenOnInsert() {
        subject.insert(SOME_LOCAL_SEARCH_MODELS)
    }

    private fun whenGetSearchResults() {
        result = subject.getTvItems(SOME_NAME).blockingFirst()
    }

    /*
     * Then
     */
    private fun thenResultIsSuccessful() {
        with(result[0]){
            assertThat(this.name).isEqualTo(SOME_NAME)
            assertThat(this.url).isEqualTo(SOME_URL)
            assertThat(this.id).isEqualTo(SOME_ID)
            assertThat(this.status).isEqualTo(SOME_STATUS)
            assertThat(this.language).isEqualTo(SOME_LANGUAGE)
            assertThat(this.type).isEqualTo(SOME_TYPE)
            assertThat(this.officialSite).isEqualTo(SOME_URL)
            assertThat(this.mediumImage).isEqualTo(SOME_URL)
            assertThat(this.originalImage).isEqualTo(SOME_URL)
        }
    }

    private fun thenResultIsEmpty() {
        assertThat(result.size).isEqualTo(0)
    }
}