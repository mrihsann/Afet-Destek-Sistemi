package com.example.afetprojesi

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.afetprojesi.presentation.views.help_system.form.HelpFormScreen
import com.example.afetprojesi.presentation.views.help_system.list.HelpList
import com.example.afetprojesi.presentation.views.home_page.HomePage
import com.example.afetprojesi.presentation.views.hook_assistance_system.list.HookAssistance
import com.example.afetprojesi.presentation.views.hook_assistance_system.form.HookAssistanceForm
import com.example.afetprojesi.presentation.views.hook_assistance_system.detail.DetailPage
import com.example.afetprojesi.presentation.views.help_system.detail.DetailRequest
import com.example.afetprojesi.presentation.views.wreckage_system.detail.DetailWreckage
import com.example.afetprojesi.presentation.views.wreckage_system.list.ListOfWreckages
import com.example.afetprojesi.presentation.views.wreckage_system.form.ReportWreckageScreen

@Composable
fun Navigation(){

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home_page") {
        composable("home_page") { HomePage(onNavigateToHelpForm = { navController.navigate("help_form") }, onNavigateToHelpList = { navController.navigate("help_list") }, onNavigateToHookAssistanceForm = { navController.navigate("hanger_form") }, onNavigateToHookAssistance = { navController.navigate("hanger_list") },onNavigateToReportWreckage = {navController.navigate("wreckage_form")},onNavigateToWreckageList = {navController.navigate("wreckage_list")}) }
        composable("help_form") { HelpFormScreen(onNavigateToHomePage = { navController.navigate("home_page") }) }
        composable("help_detail") { DetailRequest(onNavigateToPopBack = {navController.popBackStack()}) }
        composable("help_list") { HelpList(onNavigateToHomePage = { navController.navigate("home_page") }, onNavigateToDetail = {navController.navigate("help_detail")}, onNavigateToHelpForm = {navController.navigate("help_form")}) }
        composable("hanger_list") { HookAssistance(onNavigateToHomePage = { navController.navigate("home_page") }, onNavigateToDetail={navController.navigate("hanger_detail")}, onNavigateToForm = {navController.navigate("hanger_form")} ) }
        composable("hanger_detail") { DetailPage(onNavigateToPopBack = {navController.popBackStack()})}
        composable("hanger_form") { HookAssistanceForm(onNavigateToHomePage = { navController.navigate("home_page") }) }
        composable("wreckage_form") { ReportWreckageScreen(onNavigateToHomePage = { navController.navigate("home_page") }) }
        composable("wreckage_report_team") { ReportWreckageScreen(onNavigateToHomePage = { navController.popBackStack() }) }
        composable("wreckage_detail") { DetailWreckage(onNavigateToPopBack = {navController.popBackStack()}, onNavigateToReportTeam = {navController.navigate("wreckage_report_team")})}
        composable("wreckage_list") { ListOfWreckages(onNavigateToHomePage = { navController.navigate("home_page") }, onNavigateToReportWreckagePage = {navController.navigate("wreckage_form")},onNavigateToDetail = {navController.navigate("wreckage_detail")}) }
    }
}

