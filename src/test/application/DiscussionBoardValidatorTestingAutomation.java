package application;

/**
 * <p> Title: DiscussionBoardValidatorTestingAutomation Class. </p>
 * 
 * <p> Description: A Java demonstration for semi-automated tests of the 
 * DiscussionBoardValidator class. This test harness validates question creation 
 * logic including title and content requirements. </p>
 * 
 * @version 1.00	2025-11-02 Semi-automated test cases for discussion board validation
 * 
 */
public class DiscussionBoardValidatorTestingAutomation {
	
	/** Counter of the number of passed tests */
	public static int numPassed = 0;
	
	/** Counter of the number of failed tests */
	public static int numFailed = 0;

	/**
	 * This mainline displays a header to the console, performs a sequence of
	 * test cases for the DiscussionBoardValidator, and then displays a footer 
	 * with a summary of the results.
	 * 
	 * @param args Command line arguments (not used)
	 */
	public static void main(String[] args) {
		/************** Test cases semi-automation report header **************/
		System.out.println("______________________________________");
		System.out.println("\nDiscussion Board Validator Testing Automation");

		/************** Start of the test cases **************/
		
		// Test 1: Empty Title Test - Verifies empty titles are rejected
		performTestCase(1, "", "valid content here with more than 10 characters", "", 
						"Title cannot be empty");
		
		// Test 2: Title Too Short Test - Verifies titles with less than 5 characters are rejected
		performTestCase(2, "hi", "valid content here with more than 10 characters", "", 
						"Title must be at least 5 characters long");
		
		// Test 3: Empty Content Test - Verifies empty content is rejected
		performTestCase(3, "valid title here", "", "", 
						"Content cannot be empty");
		
		// Test 4: Short Content Test - Verifies content with less than 10 characters is rejected
		performTestCase(4, "valid title here", "short", "", 
						"Content must be at least 10 characters long");
		
		// Test 5: Valid Question Test - Verifies properly formatted questions pass validation
		performTestCase(5, "this is a valid title", 
						"this is a valid question content", "", null);
		
		/************** End of the test cases **************/
		
		/************** Test cases semi-automation report footer **************/
		System.out.println("____________________________________________________________________________");
		System.out.println();
		System.out.println("Number of tests passed: " + numPassed);
		System.out.println("Number of tests failed: " + numFailed);
	}
	
	/**
	 * This method sets up the input values for the test from the input parameters,
	 * displays test execution information, invokes the DiscussionBoardValidator
	 * that validates question data, interprets the returned value, and displays 
	 * the interpreted result.
	 * 
	 * @param testCase			The test case number for identification
	 * @param title				The question title to validate
	 * @param content			The question content to validate
	 * @param category			The question category
	 * @param expectedError		The expected error message (null if test should pass)
	 */
	public static void performTestCase(int testCase, String title, 
									   String content, String category, 
									   String expectedError) {
		/************** Display an individual test case header **************/
		System.out.println("____________________________________________________________________________\n\nTest case: " + testCase);
		System.out.println("Title: \"" + title + "\"");
		System.out.println("Content: \"" + content + "\"");
		System.out.println("Category: \"" + category + "\"");
		System.out.println("______________");
		
		/************** Call the validator to process the input **************/
		String resultError = DiscussionBoardValidator.validateQuestion(title, content, category);
		
		/************** Interpret the result and display that interpreted information **************/
		System.out.println("\nValidation Result:");
		
		// If expectedError is null, we expect the test to pass (no error)
		if (expectedError == null) {
			if (resultError == null) {
				System.out.println("***Success*** The question data is valid.");
				System.out.println("Expected: No error");
				System.out.println("Received: No error");
				System.out.println("Result: PASS");
				numPassed++;
			} else {
				System.out.println("***Failure*** The question data was supposed to be valid.");
				System.out.println("Expected: No error (null)");
				System.out.println("Received: " + resultError);
				System.out.println("Result: FAIL");
				numFailed++;
			}
		}
		// We expect an error message
		else {
			if (resultError != null && resultError.equals(expectedError)) {
				System.out.println("***Success*** Received the expected error message.");
				System.out.println("Expected: " + expectedError);
				System.out.println("Received: " + resultError);
				System.out.println("Result: PASS");
				numPassed++;
			} else {
				System.out.println("***Failure*** Did not receive the expected error message.");
				System.out.println("Expected: " + expectedError);
				System.out.println("Received: " + resultError);
				System.out.println("Result: FAIL");
				numFailed++;
			}
		}
		System.out.println();
	}
}

