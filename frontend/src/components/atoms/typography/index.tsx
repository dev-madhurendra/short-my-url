import  { ReactNode } from "react";
import { Typography, TypographyProps } from "@mui/material";
import { TYPOGRAPHY_DATATESTID } from "../../../utils/constants";

interface CustomTypographyProps extends TypographyProps {
  text: ReactNode;
  
}
const MuiTypography = ({ variant, sx, text, ...rest }: CustomTypographyProps) => (
  <Typography data-testid={TYPOGRAPHY_DATATESTID} variant={variant} sx={sx} {...rest}>
    {text}
  </Typography>
);

export default MuiTypography;
