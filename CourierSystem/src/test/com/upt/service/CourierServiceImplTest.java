package com.upt.service;

import com.upt.dao.CourierDAOInt;
import com.upt.dto.CourierDTO;
import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CourierServiceImplTest {

    @InjectMocks
    private CourierServiceImpl courierService;

    @Mock
    private CourierDAOInt dao;

    private CourierDTO courierDTO;

    @Before("")
    public void setUp() {
        courierDTO = new CourierDTO();
        courierDTO.setId(1L);
    }

    @Test
    public void testAdd() {
        when(dao.add(courierDTO)).thenReturn(1L);
        long result = courierService.add(courierDTO);
        assertEquals(1L, result);
        verify(dao, times(1)).add(courierDTO);
    }

    @Test
    public void testDelete() {
        doNothing().when(dao).delete(courierDTO);
        courierService.delete(courierDTO);
        verify(dao, times(1)).delete(courierDTO);
    }

    @Test
    public void testFindBypk() {
        when(dao.findBypk(1L)).thenReturn(courierDTO);
        CourierDTO result = courierService.findBypk(1L);
        assertEquals(courierDTO, result);
        verify(dao, times(1)).findBypk(1L);
    }

    @Test
    public void testUpdate() {
        doNothing().when(dao).update(courierDTO);
        courierService.update(courierDTO);
        verify(dao, times(1)).update(courierDTO);
    }

    @Test
    public void testList() {
        List<CourierDTO> courierList = Arrays.asList(courierDTO);
        when(dao.list()).thenReturn(courierList);
        List<CourierDTO> result = courierService.list();
        assertEquals(courierList, result);
        verify(dao, times(1)).list();
    }

    @Test
    public void testListWithPagination() {
        List<CourierDTO> courierList = Arrays.asList(courierDTO);
        when(dao.list(1, 10)).thenReturn(courierList);
        List<CourierDTO> result = courierService.list(1, 10);
        assertEquals(courierList, result);
        verify(dao, times(1)).list(1, 10);
    }

    @Test
    public void testSearch() {
        List<CourierDTO> courierList = Arrays.asList(courierDTO);
        when(dao.search(courierDTO)).thenReturn(courierList);
        List<CourierDTO> result = courierService.search(courierDTO);
        assertEquals(courierList, result);
        verify(dao, times(1)).search(courierDTO);
    }

    @Test
    public void testSearchWithPagination() {
        List<CourierDTO> courierList = Arrays.asList(courierDTO);
        when(dao.search(courierDTO, 1, 10)).thenReturn(courierList);
        List<CourierDTO> result = courierService.search(courierDTO, 1, 10);
        assertEquals(courierList, result);
        verify(dao, times(1)).search(courierDTO, 1, 10);
    }

    @Test
    public void testGenerateTrackingNumber() {
        when(dao.generateTrackingNumber()).thenReturn(123456789L);
        Long result = courierService.generateTrackingNumber();
        assertEquals(Long.valueOf(123456789L), result);
        verify(dao, times(1)).generateTrackingNumber();
    }
}
