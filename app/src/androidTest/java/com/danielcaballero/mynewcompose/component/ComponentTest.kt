package com.danielcaballero.mynewcompose.component

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.danielcaballero.mynewcompose.components.DanielComponent
import org.junit.Rule
import org.junit.Test

class ComponentTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun myFirstTest() {
        composeTestRule.setContent {
            DanielComponent()
        }
        ///FINDER
        composeTestRule.onNodeWithText("Daniel", ignoreCase = true)
        composeTestRule.onNodeWithTag("component1")
        composeTestRule.onAllNodesWithContentDescription("superImage")

        composeTestRule.onAllNodesWithText("d").onFirst()
        composeTestRule.onAllNodesWithTag("component1")
        composeTestRule.onAllNodesWithContentDescription("visualIcon")

        //ACTIONS
        composeTestRule.onAllNodesWithText("d").onFirst().performClick()
        composeTestRule.onNodeWithText("Daniel", ignoreCase = true).performClick()
        composeTestRule.onNodeWithText("Daniel").performTouchInput {
            doubleClick()
            longClick()
            swipeDown()
            swipeUp()
            swipeRight()
            swipeLeft()
        }
        composeTestRule.onNodeWithText("Daniel").performScrollTo().performClick()
            .performTextInput("")
        composeTestRule.onNodeWithText("Daniel").performImeAction()
        composeTestRule.onNodeWithText("Daniel").performTextClearance()
        composeTestRule.onNodeWithText("Daniel").performTextInput("asdasdsad")
        composeTestRule.onNodeWithText("Daniel").performTextReplacement("adfdfdf")

        //ASSERTIONS
        composeTestRule.onNodeWithText("Daniel").assertExists()
        composeTestRule.onNodeWithText("Daniel").assertDoesNotExist()
        composeTestRule.onNodeWithText("Daniel").assertContentDescriptionEquals("dfsdf")
        composeTestRule.onNodeWithText("Daniel").assertContentDescriptionContains("dfsdf")
        composeTestRule.onNodeWithText("Daniel").assertIsDisplayed()
        composeTestRule.onNodeWithText("Daniel").assertIsNotDisplayed()
        composeTestRule.onNodeWithText("Daniel").assertIsEnabled()
        composeTestRule.onNodeWithText("Daniel").assertIsNotEnabled()
        composeTestRule.onNodeWithText("Daniel").assertIsSelected()
        composeTestRule.onNodeWithText("Daniel").assertIsNotSelected()
        composeTestRule.onNodeWithText("Daniel").assertIsFocused()
        composeTestRule.onNodeWithText("Daniel").assertIsNotFocused()
        composeTestRule.onNodeWithText("Daniel").assertIsOn()
        composeTestRule.onNodeWithText("Daniel").assertIsOff()
        composeTestRule.onNodeWithText("Daniel").assertTextEquals("")
        composeTestRule.onNodeWithText("Daniel").assertTextContains("Daniel")
    }

    @Test
    fun whenComponentSstart_thenVerifyContentIsDaniel(){
        composeTestRule.setContent {
            DanielComponent()
        }

        composeTestRule.onNodeWithText("Daniel", ignoreCase = true).assertExists()
        composeTestRule.onNodeWithTag("textFieldName").assertTextContains("Daniel")
    }

    @Test
    fun wenNameIsAdded_thenVerifyTextContainsGreeting(){
        composeTestRule.setContent {
            DanielComponent()
        }
        composeTestRule.onNodeWithTag("textFieldName").performTextReplacement("pepe")
        composeTestRule.onNodeWithTag("textGreeting").assertTextContains("Te llamas pepe")
    }
}