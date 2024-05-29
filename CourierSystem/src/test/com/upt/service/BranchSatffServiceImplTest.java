package com.upt.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.upt.dao.BranchStaffDAOInt;
import com.upt.dto.BranchStaffDTO;
import com.upt.exception.DuplicateRecordException;

public class BranchSatffServiceImplTest {

    @InjectMocks
    private BranchSatffServiceImpl branchSatffService;

    @Mock
    private BranchStaffDAOInt branchStaffDAO;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAdd() throws DuplicateRecordException {
        BranchStaffDTO dto = new BranchStaffDTO();
        when(branchStaffDAO.add(dto)).thenReturn(1L);

        long pk = branchSatffService.add(dto);

        assertEquals(1L, pk);
        verify(branchStaffDAO, times(1)).add(dto);
    }

    @Test
    public void testList() {
        BranchStaffDTO dto1 = new BranchStaffDTO();
        BranchStaffDTO dto2 = new BranchStaffDTO();
        List<BranchStaffDTO> expectedList = Arrays.asList(dto1, dto2);
        when(branchStaffDAO.list()).thenReturn(expectedList);

        List<BranchStaffDTO> actualList = branchSatffService.list();

        assertEquals(expectedList, actualList);
        verify(branchStaffDAO, times(1)).list();
    }

    @Test
    public void testListWithPagination() {
        BranchStaffDTO dto1 = new BranchStaffDTO();
        BranchStaffDTO dto2 = new BranchStaffDTO();
        List<BranchStaffDTO> expectedList = Arrays.asList(dto1, dto2);
        when(branchStaffDAO.list(1, 2)).thenReturn(expectedList);

        List<BranchStaffDTO> actualList = branchSatffService.list(1, 2);

        assertEquals(expectedList, actualList);
        verify(branchStaffDAO, times(1)).list(1, 2);
    }

    @Test
    public void testSearch() {
        BranchStaffDTO searchDto = new BranchStaffDTO();
        BranchStaffDTO dto1 = new BranchStaffDTO();
        BranchStaffDTO dto2 = new BranchStaffDTO();
        List<BranchStaffDTO> expectedList = Arrays.asList(dto1, dto2);
        when(branchStaffDAO.search(searchDto)).thenReturn(expectedList);

        List<BranchStaffDTO> actualList = branchSatffService.search(searchDto);

        assertEquals(expectedList, actualList);
        verify(branchStaffDAO, times(1)).search(searchDto);
    }

    @Test
    public void testSearchWithPagination() {
        BranchStaffDTO searchDto = new BranchStaffDTO();
        BranchStaffDTO dto1 = new BranchStaffDTO();
        BranchStaffDTO dto2 = new BranchStaffDTO();
        List<BranchStaffDTO> expectedList = Arrays.asList(dto1, dto2);
        when(branchStaffDAO.search(searchDto, 1, 2)).thenReturn(expectedList);

        List<BranchStaffDTO> actualList = branchSatffService.search(searchDto, 1, 2);

        assertEquals(expectedList, actualList);
        verify(branchStaffDAO, times(1)).search(searchDto, 1, 2);
    }

    @Test
    public void testDelete() {
        BranchStaffDTO dto = new BranchStaffDTO();

        branchSatffService.delete(dto);

        verify(branchStaffDAO, times(1)).delete(dto);
    }

    @Test
    public void testFindBypk() {
        BranchStaffDTO expectedDto = new BranchStaffDTO();
        when(branchStaffDAO.findBypk(1L)).thenReturn(expectedDto);

        BranchStaffDTO actualDto = branchSatffService.findBypk(1L);

        assertEquals(expectedDto, actualDto);
        verify(branchStaffDAO, times(1)).findBypk(1L);
    }

    @Test
    public void testUpdate() throws DuplicateRecordException {
        BranchStaffDTO dto = new BranchStaffDTO();

        branchSatffService.update(dto);

        verify(branchStaffDAO, times(1)).update(dto);
    }

    @Test
    public void testFindByUserId() {
        BranchStaffDTO expectedDto = new BranchStaffDTO();
        when(branchStaffDAO.findByUserId(1L)).thenReturn(expectedDto);

        BranchStaffDTO actualDto = branchSatffService.findByUserId(1L);

        assertEquals(expectedDto, actualDto);
        verify(branchStaffDAO, times(1)).findByUserId(1L);
    }
}
