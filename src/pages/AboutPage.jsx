import React from "react";

function AboutPage() {
  return (
    <div style={{ fontFamily: "Arial, sans-serif", lineHeight: "1.6" }}>
      {/* Hero Section */}
      <section style={{ backgroundColor: "#fdf0f6", padding: "60px 40px", textAlign: "center" }}>
        <h1 style={{ fontSize: "3rem", color: "#d6366c", marginBottom: "20px" }}>About Wezen Telecom</h1>
        <p style={{ fontSize: "1.2rem", maxWidth: "800px", margin: "0 auto", color: "#444" }}>
          Wezen Telecom is dedicated to connecting people and businesses with high-speed internet and reliable communication solutions. 
          Our mission is to provide seamless connectivity, affordable plans, and cutting-edge telecom services to everyone.
        </p>
      </section>

      {/* Vision / Mission / Values */}
      <section style={{ display: "flex", flexWrap: "wrap", justifyContent: "center", padding: "60px 40px", gap: "40px" }}>
        <div style={{ maxWidth: "300px", textAlign: "center" }}>
          <h3 style={{ fontSize: "1.5rem", color: "#9b287b" }}>Our Vision</h3>
          <p>To be the leading telecom provider delivering innovative and reliable connectivity solutions worldwide.</p>
        </div>
        <div style={{ maxWidth: "300px", textAlign: "center" }}>
          <h3 style={{ fontSize: "1.5rem", color: "#9b287b" }}>Our Mission</h3>
          <p>Empowering communities and businesses through fast, affordable, and dependable communication networks.</p>
        </div>
        <div style={{ maxWidth: "300px", textAlign: "center" }}>
          <h3 style={{ fontSize: "1.5rem", color: "#9b287b" }}>Our Values</h3>
          <p>Innovation, Reliability, Customer-first approach, and Sustainability in every service we provide.</p>
        </div>
      </section>

      {/* Why Choose Us */}
      <section style={{ backgroundColor: "#fff0f6", padding: "60px 40px", textAlign: "center" }}>
        <h2 style={{ fontSize: "2rem", color: "#d6366c", marginBottom: "20px" }}>Why Choose Wezen?</h2>
        <p style={{ maxWidth: "700px", margin: "0 auto", color: "#555" }}>
          With state-of-the-art infrastructure and customer-centric services, Wezen Telecom ensures uninterrupted connectivity, 
          lightning-fast internet, and reliable support to help you stay connected wherever you are.
        </p>
      </section>
    </div>
  );
}

export default AboutPage;
