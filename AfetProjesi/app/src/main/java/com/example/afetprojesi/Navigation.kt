package com.example.afetprojesi

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.afetprojesi.presentation.views.help_system.helpform.HelpFormScreen
import com.example.afetprojesi.presentation.views.help_system.helplist.HelpList
import com.example.afetprojesi.presentation.views.home_page.HomePage
import com.example.afetprojesi.presentation.views.hanger_system.list_hanger.HangerList
import com.example.afetprojesi.presentation.views.hanger_system.add_to_hanger.HangerForm
import com.example.afetprojesi.presentation.views.hanger_system.detail_hanger_form.DetailHangerForm
import com.example.afetprojesi.presentation.views.wreckage_system.list_wreckage.ListOfWreckages
import com.example.afetprojesi.presentation.views.wreckage_system.report_wreckage.ReportWreckageScreen

@Composable
fun NavigationApp(){

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home_page") {
        composable("home_page") { HomePage(onNavigateToHelpForm = { navController.navigate("help_form") }, onNavigateToHelpList = { navController.navigate("help_list") }, onNavigateToHangerForm = { navController.navigate("hanger_form") }, onNavigateToHangerList = { navController.navigate("hanger_list") },onNavigateToReportWreckagePage = {navController.navigate("wreckage_form")},onNavigateToWreckageListPage = {navController.navigate("wreckage_list")}) }
        composable("help_form") { HelpFormScreen(onNavigateToHomePage = { navController.navigate("home_page") }) }
        composable("help_list") { HelpList(onNavigateToHomePage = { navController.navigate("home_page") }) }
        composable("hanger_list") { HangerList(onNavigateToHomePage = { navController.navigate("home_page") } ) }
        composable("hanger_form") { HangerForm(onNavigateToHomePage = { navController.navigate("home_page") }) }
        composable("wreckage_form") { ReportWreckageScreen(onNavigateToHomePage = { navController.navigate("home_page") }) }
        composable("wreckage_list") { ListOfWreckages(onNavigateToHomePage = { navController.navigate("home_page") }, onNavigateToReportWreckagePage = {navController.navigate("wreckage_form")}) }
    }
}