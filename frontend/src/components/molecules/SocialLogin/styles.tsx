import { Box } from "@mui/material";
import { styled } from "@mui/system";

export const StylesBox = styled(Box)({
    display: "flex",
    flexDirection: "column",
    justifyContent: "center",
    alignItems: "center",
    padding: "20px 40px",
    gap: "8px",
    background: "#FAFCFF",
    border: "1px solid #E8E8F7",
    borderRadius: "12px",
    width: "90px",
    height: "60px",
    transition: "all 0.3s ease",
    cursor: "pointer",
    "&:hover": {
      background: "#E8E8F7",
      transform: "scale(1.07)",
      boxShadow: "0px 4px 12px rgba(0, 0, 0, 0.1)",
    },
  });