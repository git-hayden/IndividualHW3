package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * <p> Title: DiscussionBoardValidatorTest Class. </p>
 * 
 * <p> Description: Automated unit tests for the DiscussionBoardValidator class </p>
 * 
 * @version 1.00  init auto test suite
 * 
 */
class DiscussionBoardValidatorTest {
    
    /**
     * Test 1: Empty Title Test
     * Verifies that an empty title is properly rejected with appropriate error message
     */
    @Test
    void testCreateQuestionWithEmptyTitle(){
        //Setup test with empty data
        String title = "";
        String validContent = "this is a valid question content with more than 10 chars.";
        String category = "";

        //Call the method
        String result = DiscussionBoardValidator.validateQuestion(title, validContent, category);

        //Verify Result
        assertEquals("Title cannot be empty", result, "Should return error for empty title");
    }
    
    /**
     * Test 2: Title Too Short Test
     * Verifies that a title with less than 5 characters is properly rejected
     */
    @Test
    void testCreateQuestionWithInvalidTitle(){
        String shortTitle = "hi";
        String validContent = "this is a valid question content with invalid title";
        String category = "";

        //Call method
        String result = DiscussionBoardValidator.validateQuestion(shortTitle, validContent, category);

        assertEquals("Title must be at least 5 characters long", result, "Should return error for less " +
                "than 5 chars");
    }
    
    /**
     * Test 3: Empty Content Test
     * Verifies that empty question content is properly rejected with appropriate error message
     */
    @Test
    void testCreateQuestionWithEmptyContent(){
        String validTitle = "this is a valid title";
        String emptyContent = "";
        String category = "";

        //call method
        String result = DiscussionBoardValidator.validateQuestion(validTitle, emptyContent, category);
        assertEquals("Content cannot be empty", result, "Should return error for empty content");
    }

    /**
     * Test 4: Short Content Test
     * Verifies that question content with less than 10 characters is properly rejected
     */
    @Test
    void testCreateQuestionWithShortContent(){
        String validTitle = "this is a valid title";
        String shortContent = "short";
        String category = "";

        //call method
        String result = DiscussionBoardValidator.validateQuestion(validTitle, shortContent, category);
        assertEquals("Content must be at least 10 characters long", result, "Should return error for " +
                "content less than 10 chars");
    }

    /**
     * Test 5: Valid Question Test
     * Verifies that a properly formatted question with valid title and content passes validation
     */
    @Test
    void testCreateValidQuestion(){
        String validTitle = "this is a valid title";
        String validContent = "this is a valid question content";
        String category = "";

        //call method
        String result = DiscussionBoardValidator.validateQuestion(validTitle, validContent, category);
        assertNull(result, "Should return null for valid question data");
    }

}