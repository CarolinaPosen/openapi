package by.mikhalevich.architecture.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import by.mikhalevich.architecture.model.Aircraft;
import by.mikhalevich.architecture.repositories.AircraftCrudRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

import java.util.HashSet;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {AircraftController.class})
@ExtendWith(SpringExtension.class)
class AircraftControllerTest {

    @Autowired
    private AircraftController aircraftController;

    @MockBean
    private AircraftCrudRepository aircraftCrudRepository;

    /**
     * Method under test: {@link AircraftController#createAircraft(Aircraft)}
     */
    @Test
    void testCreateAircraft() throws Exception {
        Aircraft aircraft = new Aircraft();
        aircraft.setFlights(new HashSet<>());
        aircraft.setId(123L);
        aircraft.setModel("Model");
        aircraft.setRange(1);
        when(aircraftCrudRepository.save((Aircraft) any())).thenReturn(aircraft);

        Aircraft aircraft1 = new Aircraft();
        aircraft1.setFlights(new HashSet<>());
        aircraft1.setId(123L);
        aircraft1.setModel("Model");
        aircraft1.setRange(1);
        String content = (new ObjectMapper()).writeValueAsString(aircraft1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/aircrafts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(aircraftController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"id\":123,\"model\":\"Model\",\"range\":1}"));
    }

    /**
     * Method under test: {@link AircraftController#deleteGroup(Aircraft)}
     */
    @Test
    void testDeleteGroup() throws Exception {
        doNothing().when(aircraftCrudRepository).delete((Aircraft) any());

        Aircraft aircraft = new Aircraft();
        aircraft.setFlights(new HashSet<>());
        aircraft.setId(123L);
        aircraft.setModel("Model");
        aircraft.setRange(1);
        String content = (new ObjectMapper()).writeValueAsString(aircraft);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/aircrafts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(aircraftController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link AircraftController#getAircraft(long)}
     */
    @Test
    void testGetAircraft() throws Exception {
        Aircraft aircraft = new Aircraft();
        aircraft.setFlights(new HashSet<>());
        aircraft.setId(123L);
        aircraft.setModel("Model");
        aircraft.setRange(1);
        Optional<Aircraft> ofResult = Optional.of(aircraft);
        when(aircraftCrudRepository.findById((Long) any())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/aircrafts/{id}", 123L);
        MockMvcBuilders.standaloneSetup(aircraftController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"id\":123,\"model\":\"Model\",\"range\":1}"));
    }

    /**
     * Method under test: {@link AircraftController#getAircrafts()}
     */
    @Test
    void testGetAircrafts() throws Exception {
        when(aircraftCrudRepository.findAll()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/aircrafts");
        MockMvcBuilders.standaloneSetup(aircraftController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link AircraftController#getAircrafts()}
     */
    @Test
    void testGetAircrafts2() throws Exception {
        when(aircraftCrudRepository.findAll()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/aircrafts");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(aircraftController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link AircraftController#updateAircraft(Aircraft)}
     */
    @Test
    void testUpdateAircraft() throws Exception {
        Aircraft aircraft = new Aircraft();
        aircraft.setFlights(new HashSet<>());
        aircraft.setId(123L);
        aircraft.setModel("Model");
        aircraft.setRange(1);
        when(aircraftCrudRepository.save((Aircraft) any())).thenReturn(aircraft);

        Aircraft aircraft1 = new Aircraft();
        aircraft1.setFlights(new HashSet<>());
        aircraft1.setId(123L);
        aircraft1.setModel("Model");
        aircraft1.setRange(1);
        String content = (new ObjectMapper()).writeValueAsString(aircraft1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/aircrafts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(aircraftController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"id\":123,\"model\":\"Model\",\"range\":1}"));
    }

}

