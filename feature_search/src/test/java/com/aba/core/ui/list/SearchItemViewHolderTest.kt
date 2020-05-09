package com.aba.core.ui.list

import com.aba.core.SOME_SEARCH_MODEL
import com.aba.core.any
import com.aba.core.base.ViewHolderTestBase
import com.aba.search.R
import com.nhaarman.mockitokotlin2.then
import junit.framework.Assert.assertTrue
import kotlinx.android.synthetic.main.item_seach.view.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations.initMocks


class SearchItemViewHolderTest : ViewHolderTestBase<SearchItemViewHolder>() {

    @Mock
    lateinit var mockCallback: SearchListAdapter.SearchAdapterCallback

    @Before
    fun setup() {
        initMocks(this)
        createViewHolder(R.layout.item_seach) {
            SearchItemViewHolder(it, mockCallback)
        }
    }

    @Test
    fun `whenOnBindView thenSetListener AndThenBindText `() {
        whenOnBindView()
        thenSetListener()
        thenBindText()
    }

    @Test
    fun `whenOnBindView whenOnItemViewClicked thenCallbackIsCalled`(){
        whenOnBindView()
        whenOnItemViewClicked()
        thenCallbackIsCalled()
    }


    /*
     * When
     */
    private fun whenOnBindView() {
        subject.bindView(SOME_SEARCH_MODEL)
    }

    private fun whenOnItemViewClicked() {
        subject.itemView.performClick()
    }

    /*
     * Then
     */
    private fun thenSetListener() {
        assertTrue(subject.itemView.hasOnClickListeners())
    }

    private fun thenBindText() {
        with(subject.itemView){
            assertThat(searchTitle.text).isEqualTo(SOME_SEARCH_MODEL.name)
        }
    }

    private fun thenCallbackIsCalled() {
        then(mockCallback).should().onSearchItem(any())
    }


}