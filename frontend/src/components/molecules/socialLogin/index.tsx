import MuiTypography from "../../atoms/typography";
import { Box } from "@mui/material";
import IconComponent from "../../atoms/icon";
import { styled } from "@mui/system";

interface SocialLoginProps {
  text: string;
  src: string;
}

const StylesBox = styled(Box)({
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

const SocialLogin = ({ text, src }: SocialLoginProps) => {
  return (
    <StylesBox data-testid="socialIconComponent">
      <IconComponent src={src} />
      <MuiTypography text={text} sx={{ color: "#7D7D89" }} />
    </StylesBox>
  );
};
export default SocialLogin;
