Public Class StadiumSeating





    Private Sub btnExit_Click(sender As Object, e As EventArgs) Handles btnExit.Click
        Me.Close()
    End Sub

    Private Sub btnClear_Click(sender As Object, e As EventArgs) Handles btnClear.Click
        txtClassA.Clear()
        txtClassB.Clear()
        txtClassC.Clear()
        txtRevenueA.Clear()
        txtRevenueB.Clear()
        txtRevenueC.Clear()
        txtTotalRevenue.Clear()
        'set focus to txtClassA
        txtClassA.Focus()

    End Sub

    Private Sub btnCalculate_Click(sender As Object, e As EventArgs) Handles btnCalculate.Click
        Dim intClassA, intClassB, intClassC As Integer
        Dim decRevenueA, decRevenueB, decRevenueC, decTotalRevenue As Decimal
        intClassA = txtClassA.Text
        intClassB = txtClassB.Text
        intClassC = txtClassC.Text
        decRevenueA = txtRevenueA.Text
        decRevenueB = txtRevenueB.Text
        decRevenueC = txtRevenueC.Text
        decTotalRevenue = txtTotalRevenue.Text
        decRevenueA = intClassA * 15
        decRevenueB = intClassB * 12
        decRevenueC = intClassC * 9
        decTotalRevenue = decRevenueA + decRevenueB + decRevenueC
    End Sub
End Class
