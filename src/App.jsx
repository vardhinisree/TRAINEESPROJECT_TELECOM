import { Routes, Route } from "react-router-dom";
import LandingPage from "./pages/LandingPage";
import ExplorePage from "./pages/ExplorePage";
import AboutPage from "./pages/AboutPage";
import ContactPage from "./pages/ContactPage";
import LoginPage from "./pages/LoginPage";
import SignupPage from "./pages/SignupPage";
import PrepaidPlansPage from "./pages/PrepaidPlansPage";
import PostpaidPlansPage from "./pages/PostpaidPlansPage";
import ComplaintsPage from "./pages/ComplaintsPage";

export default function App() {
  return (
    <Routes>
      <Route path="/" element={<LandingPage />} />
      <Route path="/explore" element={<ExplorePage />} />
      <Route path="/about" element={<AboutPage />} />
      <Route path="/contact" element={<ContactPage />} />
      <Route path="/login" element={<LoginPage />} />
      <Route path="/signup" element={<SignupPage />} />
      <Route path="/prepaid" element={<PrepaidPlansPage />} />
      <Route path="/postpaid" element={<PostpaidPlansPage />} />
      <Route path="/complaints" element={<ComplaintsPage />} />
    </Routes>
  );
}
