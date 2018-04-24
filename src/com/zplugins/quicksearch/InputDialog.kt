package com.zplugins.quicksearch

import com.intellij.ide.BrowserUtil
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.DialogWrapper
import java.awt.event.*
import javax.swing.JComponent
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.JTextArea

class InputDialog(private val project: Project) : DialogWrapper(project) {

    val inputArea: JTextArea = JTextArea()
    //    val frame: JFrame = JFrame()
    val pannel: JPanel = JPanel()

    init {
        init()
        title = "search it!"
        window.pack()
        window.requestFocus()
        window.isVisible = true
    }

    override fun createCenterPanel(): JComponent? {

        inputArea.rows = 1
        inputArea.addKeyListener(object : KeyListener {
            override fun keyTyped(e: KeyEvent?) {

            }

            override fun keyPressed(e: KeyEvent?) {
                if (e!!.keyCode == KeyEvent.VK_ENTER) {
                    browseBy(inputArea.text)
                    doOKAction()
                }
            }

            override fun keyReleased(e: KeyEvent?) {
            }
        }
        )


        return inputArea
    }

    override fun doOKAction() {
        super.doOKAction()
        browseBy(inputArea.text)
    }

    fun browseBy(input: String) {
        BrowserUtil.browse("https://www.google.co.kr/search?q=$input")
    }

    fun focusInput() {
        inputArea.requestFocusInWindow()
    }

}