package com.example.testtask.data.repositories.ageOfEmpires

import com.example.testtask.data.db.dao.CivilizationDao
import com.example.testtask.data.network.ApiDao
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.junit.MockitoJUnit
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CivilizationsTwoWayRepositoryTest {
    @get:Rule
    val mockitoRule = MockitoJUnit.rule()

    lateinit var apiDao: ApiDao

    @Mock
    lateinit var civilizationDao: CivilizationDao

    private lateinit var civilizationsTwoWayRepository: CivilizationsTwoWayRepository

    lateinit var mockWebServer: MockWebServer

    private val civilizationsList: String = "{\n" +
            "  \"civilizations\": [\n" +
            "    {\n" +
            "      \"id\": 0,\n" +
            "      \"name\": \"string\",\n" +
            "      \"expansion\": \"string\",\n" +
            "      \"army_type\": \"string\",\n" +
            "      \"unique_unit\": [\n" +
            "        \"string\"\n" +
            "      ],\n" +
            "      \"unique_tech\": [\n" +
            "        \"string\"\n" +
            "      ],\n" +
            "      \"team_bonus\": \"string\",\n" +
            "      \"civilization_bonus\": [\n" +
            "        \"string\"\n" +
            "      ]\n" +
            "    }\n" +
            "  ]\n" +
            "}"

    @Before
    fun setUp() {
        mockWebServer = MockWebServer()

        apiDao = Retrofit.Builder()
            .baseUrl(mockWebServer.url("").toString())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
            .create(ApiDao::class.java)

        civilizationsTwoWayRepository = CivilizationsTwoWayRepository(apiDao, civilizationDao)
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Test
    fun getCivilizationsFromAPIAsync() {
        runBlocking {
            /**
             * Normal response
             */
            mockWebServer.enqueue(MockResponse().setBody(civilizationsList))

            var civilizations = civilizationsTwoWayRepository.getCivilizationsFromAPIAsync().await()

            assert(civilizations.civilizations.isNotEmpty())

            /**
             * Error response
             */
            mockWebServer.enqueue(MockResponse().setResponseCode(500))
            try {
                civilizations = civilizationsTwoWayRepository.getCivilizationsFromAPIAsync().await()
            } catch (e: HttpException) {

            }
        }
    }
}