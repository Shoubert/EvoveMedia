Public Class frmRomanNumericConverter

    Private Sub btnConvert_Click(sender As System.Object, e As System.EventArgs) Handles btnConvert.Click
        Dim Value1 As Double
        Dim Value2 As String
        Value1 = CDbl(txtValue1.Text)
        Value2 = CStr(txtValue2.Text)
        Select Case CDbl(txtValue1.Text)
            Case Is = 1
                txtValue2.Text = "I"
            Case Is = 2
                txtValue2.Text = "II"
            Case Is = 3
                txtValue2.Text = "III"
            Case Is = 4
                txtValue2.Text = "IV"
            Case Is = 5
                txtValue2.Text = "V"
            Case Is = 6
                txtValue2.Text = "VI"
            Case Is = 7
                txtValue2.Text = "VII"
            Case Is = 8
                txtValue2.Text = "VIII"
            Case Is = 9
                txtValue2.Text = "IV"
            Case Is = 10
                txtValue2.Text = "X"
        End Select


    End Sub

    Private Sub txtExit_Click(sender As System.Object, e As System.EventArgs) Handles txtExit.Click
        Me.Close()
    End Sub
End Class
