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

import com.upt.dao.BranchDAOInt;
import com.upt.dto.BranchDTO;
import com.upt.exception.DuplicateRecordException;

public class BranchServiceImplTest {

    @InjectMocks
    private BranchServiceImpl branchService;

    @Mock
    private BranchDAOInt branchDAO;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAdd() throws DuplicateRecordException {
        BranchDTO dto = new BranchDTO();
        when(branchDAO.add(dto)).thenReturn(1L);

        long pk = branchService.add(dto);

        assertEquals(1L, pk);
        verify(branchDAO, times(1)).add(dto);
    }

    @Test
    public void testList() {
        BranchDTO dto1 = new BranchDTO();
        BranchDTO dto2 = new BranchDTO();
        List<BranchDTO> expectedList = Arrays.asList(dto1, dto2);
        when(branchDAO.list()).thenReturn(expectedList);

        List<BranchDTO> actualList = branchService.list();

        assertEquals(expectedList, actualList);
        verify(branchDAO, times(1)).list();
    }

    @Test
    public void testListWithPagination() {
        BranchDTO dto1 = new BranchDTO();
        BranchDTO dto2 = new BranchDTO();
        List<BranchDTO> expectedList = Arrays.asList(dto1, dto2);
        when(branchDAO.list(1, 2)).thenReturn(expectedList);

        List<BranchDTO> actualList = branchService.list(1, 2);

        assertEquals(expectedList, actualList);
        verify(branchDAO, times(1)).list(1, 2);
    }

    @Test
    public void testSearch() {
        BranchDTO searchDto = new BranchDTO();
        BranchDTO dto1 = new BranchDTO();
        BranchDTO dto2 = new BranchDTO();
        List<BranchDTO> expectedList = Arrays.asList(dto1, dto2);
        when(branchDAO.search(searchDto)).thenReturn(expectedList);

        List<BranchDTO> actualList = branchService.search(searchDto);

        assertEquals(expectedList, actualList);
        verify(branchDAO, times(1)).search(searchDto);
    }

    @Test
    public void testSearchWithPagination() {
        BranchDTO searchDto = new BranchDTO();
        BranchDTO dto1 = new BranchDTO();
        BranchDTO dto2 = new BranchDTO();
        List<BranchDTO> expectedList = Arrays.asList(dto1, dto2);
        when(branchDAO.search(searchDto, 1, 2)).thenReturn(expectedList);

        List<BranchDTO> actualList = branchService.search(searchDto, 1, 2);

        assertEquals(expectedList, actualList);
        verify(branchDAO, times(1)).search(searchDto, 1, 2);
    }

    @Test
    public void testDelete() {
        BranchDTO dto = new BranchDTO();

        branchService.delete(dto);

        verify(branchDAO, times(1)).delete(dto);
    }

    @Test
    public void testFindBypk() {
        BranchDTO expectedDto = new BranchDTO();
        when(branchDAO.findBypk(1L)).thenReturn(expectedDto);

        BranchDTO actualDto = branchService.findBypk(1L);

        assertEquals(expectedDto, actualDto);
        verify(branchDAO, times(1)).findBypk(1L);
    }

    @Test
    public void testUpdate() throws DuplicateRecordException {
        BranchDTO dto = new BranchDTO();

        branchService.update(dto);

        verify(branchDAO, times(1)).update(dto);
    }
}
